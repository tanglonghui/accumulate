chcp 65001
@echo off
:: 提示用户输入他们的名字
set /p name=请输入您的名字:

:: 显示输入的名字
echo 您好，%name%！

:: 提示用户输入一个数字
set /p number=请输入一个数字:

:: 显示输入的数字并计算它的平方
set /a square=%number% * %number%
echo 您输入的数字是 %number%，它的平方是 %square%。

pause
