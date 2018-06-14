# -*- coding: utf-8 -*-

from email import encoders
from email.header import Header
from email.mime.text import MIMEText
from email.utils import parseaddr, formataddr
import smtplib

mailto_list = ["10240@qq.com","1024@qq.com"]
mail_host="smtp.qq.com"
mail_user="dreammare"
mail_pass="dreammare"
mail_postfix="qq.com"
def send_mail(mailto_list):
   me=mail_user+"@"+mail_postfix
   msg = MIMEText("Hi,how are you ?",'plain','utf-8')
   msg['Subject']="Love"
   msg['From'] = me
   msg['To']=";".join(mailto_list)
   try:
	s=smtplib.SMTP_SSL(mail_host,465)
	s.set_debuglevel(1)
	s.login(mail_user,mail_pass)
	s.sendmail(me,mailto_list,msg.as_string())
	s.close()
	return True
   except Exception, e:
	print str(e)
	return False
	  
if __name__=='__main__':
  if send_mail(mailto_list):
    print "Success"
  else:
    print "Fail"