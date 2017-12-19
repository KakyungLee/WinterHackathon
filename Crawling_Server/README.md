## INPUT
http://server.url/search/<str:검색어>/<int:현 페이지>

## OUTPUT
{
    'word': '(검색어)',
    'page': (현 페이지),
    'max_page': (끝 페이지),
    'next': (True/False: 다음 페이지 가능 여부),
    'data': [
        {
            'BOOK_NUM': (원본페이지 DB에서의 책 번호).
            'BOOK_NAME': '(도서명)'.
            'BOOK_INFO': '(저자, 출판사, 연도)'.
            'BOOK_CODE': '(청구기호)'.
            'BOOK_STATUS': '(도서상태: 대출가능, 대출불가, 폐기대상)'.
            'BOOK_IMGURL': '(도서표지이미지 링크)'.
        },
        {
            'BOOK_NUM': (원본페이지 DB에서의 책 번호).
            'BOOK_NAME': '(도서명)'.
            'BOOK_INFO': '(저자, 출판사, 연도)'.
            'BOOK_CODE': '(청구기호)'.
            'BOOK_STATUS': '(도서상태: 대출가능, 대출불가, 폐기대상)'.
            'BOOK_IMGURL': '(도서표지이미지 링크)'.
        },
        {
            'BOOK_NUM': (원본페이지 DB에서의 책 번호).
            'BOOK_NAME': '(도서명)'.
            'BOOK_INFO': '(저자, 출판사, 연도)'.
            'BOOK_CODE': '(청구기호)'.
            'BOOK_STATUS': '(도서상태: 대출가능, 대출불가, 폐기대상)'.
            'BOOK_IMGURL': '(도서표지이미지 링크)'.
        },
        ...(생략)
    ]
}