@echo off
RD /S /Q  "E:\eclipse-jee\workspace\oa-server\lvqibin-oa\lvqibin-oa-web\src\main\resources\api\"
E:
cd E:\eclipse-jee\workspace\oa-server\lvqibin-oa\lvqibin-oa-web
apidoc -i ./ -o ./src/main/resources/api