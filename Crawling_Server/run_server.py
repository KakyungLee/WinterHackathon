from flask import Flask, render_template, request, session, url_for, redirect
from crawling_lib import search

app = Flask(__name__)

# ============================================================================

@app.route("/search/<word>/<int:page>")
def search_result(word, page):
    d = search(word, page)

    s = "{"
    s = s + "'word': '" + word + "', "
    s = s + "'page': " + str(page) + ","
    s = s + "'max_page': " + str(d['max_page']) + ", "
    s = s + "'next': " + str(d['next']) + ", "
    s = s + "'data': " + str(d['data'])
    s = s + "}"
    
    return s

@app.route("/")
def root():
    return "Hello, Flask!"

# =============================================================================

if __name__ == "__main__":
    app.debug = True
    app.run(host="172.31.44.210", threaded=True)
