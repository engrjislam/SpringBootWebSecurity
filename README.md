# SpringBootWebSecurity

This project try to implement spring security with better approache(s). If you got something wrong, feel free to share your idea(s). Please leave your suggestion(s) to this simple project.


### What you need to do?

1. You just need to run a query named src > main > resources > docx > database > sql > combined > (ddl.sql & dml.sql).

2. Change database username & jasypt encrypted password in src > main > resources > application.properties [This application fetch database credeentials provided in application.properties by java > com > maxpro > configuration > database > DatabaseConfiguration.java class. At first add compile('org.jasypt:jasypt-spring3:1.9.1') to build.gradle file. Download Jasypt from https://sourceforge.net/projects/jasypt/files/ and add to your PATH variable. Read http://www.jasypt.org/cli.html and encrypt your database password and then put encrypted password to your application.properties file to the line spring.datasource.password=ENC(SMUg5WCOm2Lw1RR2pk2xFHSXKtg4mElq) and replace SMUg5WCOm2Lw1RR2pk2xFHSXKtg4mElq by encrypted password. According the Jasypt documentation you need two parameters to encrypt a password. First is input (denotes database password) & second is password (the secret key by which you can encrypt your password, this will be used decrypt the jasypt encrypted password). If your database password is x12345 and your encryption key is supersecretz then encrypt it by command line as > encrypt input="x12345" password=supersecretz . You just need to access supersetretz from JVM argument You can fetch.You need two more things. Add bootRun { systemProperties System.properties } to build.gradle and the project by following command].

3. Run the project from your cmd/terminal (supersecretz will fetch by java > com > maxpro > configuration > database > DatabaseConfiguration.java through example..jasypt.key value) -> gradle -Dexample..jasypt.key=supersecretz bootRun .


### Future work:

1. Will work on session management.

2. Fragment view page(s).

### References:

1. http://www.ekiras.com/2016/04/authenticate-user-with-custom-user-details-service-in-spring-security.html

2. http://stackoverflow.com/questions/41533244/repository-returns-null-in-spring-security

3. https://codahale.com/how-to-safely-store-a-password/

4. http://spr.com/part-5a-additional-credential-security-spring-data-jpa-jasypt/

5. http://stackoverflow.com/questions/23367507/how-to-pass-system-property-to-gradle-task


###### Happy coding ... :) :) :) 
