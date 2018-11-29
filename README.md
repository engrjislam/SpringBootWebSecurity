# SpringBootWebSecurity

This project try to implement spring security with better approache(s). If you got something wrong, feel free to share your idea(s). Please leave your suggestion(s) to this simple project.


### What you need to do?

1. You just need to run a query named src > main > resources > docx > database > sql > combined > (ddl.sql & dml.sql).
2. Change database username & jasypt encrypted password in src > main > resources > application.properties 
3. Run the project from your cmd/terminal 

        gradle -Dauth.key=authKey bootRun

#### Encrypt database password

1. Download jasypt batch file to encrypt database password from https://sourceforge.net/projects/jasypt/files/ 
2. Add the bin directory of jasypt to your system path variable
3. Add jasypt dependency to 'build.gradle'

        compile('org.jasypt:jasypt-spring3:1.9.1')

4. Encrypt password with jasypt CLI

        encrypt input=root password=authKey
        
    Here,
    - 'root'                      >  original database password  
    - 'authKey'                   >  the salt that used to encrypt 'root' (original password)
    - 'fwPDBYsbkbHVwxDGEsutsQ=='  >  encrypted password
    - 'authKey' is required at compile time to decrypt 'fwPDBYsbkbHVwxDGEsutsQ==' (encrypted password)
    - You can of course decrypt 'fwPDBYsbkbHVwxDGEsutsQ=='
  
          decrypt input=fwPDBYsbkbHVwxDGEsutsQ== password=authKey
  
5. Put the encrypted password (let's say 'fwPDBYsbkbHVwxDGEsutsQ==') at application.properties

        spring.datasource.password=ENC(fwPDBYsbkbHVwxDGEsutsQ==)
 
    Here,
    - 'authKey' will be accessed by the following command gradle will pass the value of 'auth.key' to java
    - -D [with no space(s)] prior to 'auth.key' that is -Dauth.key with '=' that is
    - -Dauth.key=authKey
    - java will get this value by 'System.getProperty("auth.key")'
  
6. Enable System properties class & add the following code to 'build.gradle'

        bootRun {    
            systemProperties System.properties
        }

7. Run the project with

        gradle -Dauth.key=authKey bootRun
 

###### The combined > dml.sql contains two user as johir1 (with user role) & johir2 (with both user & admin role). Both user uses same password i.e 12345

| username | password | access |
| -------- | -------- | ------ |
|  johir1  |  12345   | ROLE_ADMIN | 
|  johir2  |  12345   | ROLE_ADMIN, ROLE_USER |

### Future work:

In future I will work with fragment view page(s).

### References:

1. http://www.ekiras.com/2016/04/authenticate-user-with-custom-user-details-service-in-spring-security.html

2. http://stackoverflow.com/questions/41533244/repository-returns-null-in-spring-security

3. https://codahale.com/how-to-safely-store-a-password/

4. http://spr.com/part-5a-additional-credential-security-spring-data-jpa-jasypt/

5. http://stackoverflow.com/questions/23367507/how-to-pass-system-property-to-gradle-task


###### Happy coding ... :) :) :)
