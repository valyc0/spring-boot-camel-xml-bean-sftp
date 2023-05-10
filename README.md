# spring-boot-camel-xml-bean-sftp

funziona sia con il file xml (fare import 
@ImportResource("classpath:app-camel.xml")

oppure tramite component (ricordati di commentare e scommentare)

configurazione SFTP:

utente remoto: IP_REMOTE utente:mykeyftp

in locale mobaxterm:
ssh-keygen -t rsa -f D:/lavoro/ITALIA/mykey/macchine/collaudo/chiavi_ftp_collaudo/mykey.rsa -C mykeyftp

per connettersi:
ssh  -i  D:/lavoro/ITALIA/mykey/macchine/collaudo/chiavi_ftp_collaudo/mykey.rsa mykeyftp@IP_REMOTE -p 2222

cat id_rsa.pub
copy contentuto su  macchina IP_REMOTE utente mykeyftp  in 
.ssh/authorized_keys
poi chmod 700 authorized_keys
