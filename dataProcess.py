from os import listdir
import re
from urllib import request
import json

def post(tag, fileName, num):
    req = request.Request('http://localhost:7799/addQuest/' + tag)
    req.add_header('Content-Type', 'application/json; charset=utf-8')

    quest = open('questions/' + tag + '/' + fileName, 'r', encoding='utf8')
    jsondata = json.loads(quest.read())
    jsondata['num'] = int(num)
    print(num)
    jsondata = json.dumps(jsondata).encode('utf-8')
    req.add_header('Content-Length', len(jsondata))

    request.urlopen(req, jsondata)

    quest.close()

req = request.Request('http://localhost:7799/removeAll', method='DELETE')
request.urlopen(req)
for dirs in listdir('questions'):
    for fileName in listdir('questions/' + dirs):
        post(dirs, fileName, re.match(r'^question(.*).json$', fileName).group(1))
