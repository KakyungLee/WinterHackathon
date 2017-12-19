import requests
from bs4 import BeautifulSoup
import sys


def exchangeStr(src, before, after):
    x = src.find(before)
    if x != -1:
        src = src[:x] + after + src[x+len(before):]
    return src



def get_item(soup, url):
    lst = []
    ul = soup.findAll('ul', {'class': 'listType01'})[0]
    items = ul.findAll('dl', {'class': 'bookList'})

    for i in items:
        dic = {}

        j = i.findAll('div', {'class': 'body'})[0]
        aa = j.findAll('a', {'class': 'title'})
        pp = j.findAll('p', {'class': 'tag'})[0]
        
        tmp = "goDetail("
        a = str(aa[0])
        x = a.find(tmp)
        a = a[x+len(tmp):]
        tmp = ");\">"
        x = a.find(tmp)
        dic['BOOK_NUM'] = int(a[:x])
        a = a[x+len(tmp):]
        tmp = "</a>"
        x = a.find(tmp)
        dic['BOOK_NAME'] = exchangeStr(a[:x], "&amp;", "&")

        a = str(i)
        tmp = "<img "
        x = a.find(tmp)
        a = a[x+len(tmp):]
        tmp = "</a>"
        x = a.find(tmp)
        a = a[x+len(tmp):]
        tmp = "</a>"
        x = a.find(tmp)
        a = a[x+len(tmp):]
        tmp = "\t"
        x = a.find(tmp)
        dic['BOOK_INFO'] = a[:x].strip()[2:]

        a = str(pp)
        tmp = "</a>"
        x = a.find(tmp)
        a = a[x+len(tmp):]
        tmp = "<br/>"
        x = a.find(tmp)
        a = a[:x]
        tmp = "]"
        x = a.find(tmp)
        dic['BOOK_CODE'] = a[:x].strip()[1:]
        a = a[x+1:]
        dic['BOOK_STATUS'] = a.strip()


        a = str(i.findAll('img')[0])
        print(a)
        tmp = "src=\""
        x = a.find(tmp)
        a = a[x+len(tmp):]
        tmp = "\""
        x = a.find(tmp)
        a = a[:x]
        if "http://" in a:
            dic['BOOK_IMGURL'] = a
        else:
            dic['BOOK_IMGURL'] = url + a[2:]

        lst.append(dic)

    return lst



def search(word, page):
    prefix = 'http://library.sejong.ac.kr'
    url = prefix + '/search/Search.Result.ax?q='+word+'&page='+str(page)
    source_code = requests.get(url, allow_redirects=False)
    plain_text = source_code.text
    soup = BeautifulSoup(plain_text, 'html.parser')

    dic = {}
    
    pager = soup.findAll('div', {'class': 'pager'})
    if len(list(pager)) == 0:
        dic['data'] = []
        dic['max_page'] = 0
        dic['next'] = False
        return dic
    
    pager = pager[0]
    
    a = pager.findAll('a', {'class': 'next'})
    if len(list(a)) < 2:
        dic['next'] = False
        a = pager.findAll('a')
        if len(list(a)) > 0:
            b = str(a[len(list(a))-1])
            tmp = "goPage("
            x = b.find(tmp)
            b = b[x+len(tmp):]
            tmp = ");"
            x = b.find(tmp)
            dic['max_page'] = int(b[:x])
        else:
            a = pager.findAll('strong')
            if len(list(a)) == 0:
                dic['max_page'] = 0
            else:
                dic['max_page'] = 1
    else:
        b = str(a[1])
        tmp = "goPage("
        x = b.find(tmp)
        b = b[x+len(tmp):]
        tmp = ");"
        x = b.find(tmp)
        dic['max_page'] = int(b[:x])
    dic['next'] = (page < dic['max_page'])

    if dic['max_page'] == 0:
        dic['data'] = []
    else:
        dic['data'] = get_item(soup, prefix)
    
    return dic


def get_favbooks():
    lst = []

    # image
    url = 'http://library.sejong.ac.kr'
    source_code = requests.get(url+'/index.ax', allow_redirects=False)
    plain_text = source_code.text
    soup = BeautifulSoup(plain_text, 'html.parser')

    div = soup.findAll('div', {'class': 'favbooks'})[0]
    aa = div.findAll('a')

    for d in range(len(list(aa))-1):
        dic = {}
        a = str(aa[d])

        tmp = 'herf='
        x = a.find(tmp)
        a = a[x+len(tmp):]
        tmp = 'cid='
        x = a.find(tmp)
        a = a[x+len(tmp):]
        tmp = '">'
        x = a.find(tmp)
        dic['BOOK_NUM'] = int(a[:x])
        a = a[x:]

        print(a)
        tmp = 'alt="'
        x = a.find(tmp)
        a = a[x+len(tmp):]
        tmp = '"'
        x = a.find(tmp)
        dic['BOOK_NAME'] = a[:x]
        
        tmp = "src=\""
        x = a.find(tmp)
        a = a[x+len(tmp):]
        tmp = "\""
        x = a.find(tmp)
        if "http://" in a[:x]:
            dic['BOOK_IMGURL'] = a[:x]
        else:
            dic['BOOK_IMGURL'] = url + a[:x]

        dic['BOOK_INFO'] = 'None'
        dic['BOOK_CODE'] = 'None'
        dic['BOOK_STATUS'] = 'None'
        
        lst.append(dic)
    
        
    return lst

if __name__ == "__main__":
#    dic = search("Web", 1)
#    lst = dic['data']
    lst = get_favbooks()
#    print("max_page =", dic['max_page'], ", next =", dic['next'])
    for i in range(len(lst)):
        x = lst[i]
        print("#"*10 + " No. " + str(i+1) + " " + "#"*10)
        for j in list(x.keys()):
            print(j, "=\t", x[j])
