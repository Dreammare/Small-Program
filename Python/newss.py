# -*- coding: utf-8 -*-

from email.header import Header
from email.mime.text import MIMEText
from email.utils import formataddr
import smtplib

#from_addr = raw_input('From: ')
#password = raw_input('Password: ')
#to_addr = raw_input('To: ')
#smtp_server = raw_input('SMTP server: ')
from_addr = "@qq.com"
nickname = Header('System','utf-8')
nickname.append("<"+from_addr+">",'ascii')
password = ""
to_addr = ["@qq.com","@qq.com"]
smtp_server = "smtp.qq.com"

msg = MIMEText('Hello, the batch finished, please check the processes details', 'plain', 'utf-8')
msg['From'] = nickname
#msg['To'] = to_addr
msg['To']=";".join(to_addr)
msg['Subject'] = Header(u'Batch Running Information', 'utf-8').encode()
#try:
server = smtplib.SMTP_SSL(smtp_server, 465)
server.set_debuglevel(1)
server.login(from_addr, password)
 #server.sendmail(from_addr, [to_addr], msg.as_string())
server.sendmail(str(nickname), to_addr, msg.as_string())
server.quit()
# return "Success"
#except Exception, e:
# print str(e)
# return "Fail"

