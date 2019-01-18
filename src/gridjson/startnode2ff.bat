@echo on
#java -jar %1 -role node -Dwebdriver.%3.driver=%3 -nodeConfig %2
java -jar %1 -role node -Dwebdriver.firefox.driver=%3 -nodeConfig %2
@pause