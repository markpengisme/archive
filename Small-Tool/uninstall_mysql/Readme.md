# Uninstall MySQL(for mac)

*Because MySQL do not have uninstaller...*

The Content of this shell:

    sudo rm /usr/local/mysql  
    sudo rm -rf /usr/local/mysql*  
    sudo rm -rf /Library/StartupItems/MySQLCOM  
    sudo rm -rf /Library/PreferencePanes/MySQL*  
    rm -rf ~/Library/PreferencePanes/MySQL*  
    sudo rm -rf /Library/Receipts/mysql*  
    sudo rm -rf /Library/Receipts/MySQL*  
    sudo rm -rf /var/db/receipts/com.mysql.*  
    sudo rm -rf /var//mysql  
    rm -rf /var//mysql/mysql.sock  
    sudo rm -rf /var//root/.mysql_history 
    sudo rm -rf /usr/local/var/mysql  
    echo "Finally,please remove all nodes that include mysql in '/Library/Receipts/InstallHistory.plist'"  
    
**Remember to remove all nodes that include mysql in '/Library/Receipts/InstallHistory.plist'**
