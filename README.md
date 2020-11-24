# api-rest
This is a project with didactic purpose

### Installation

Configuring database password:

```sh
$ cd ~/.m2/repository/org/jasypt/jasypt/1.9.2/
$ java -cp jasypt-1.9.2.jar org.jasypt.intf.cli.JasyptPBEStringEncryptionCLI input=”your_password" password=dev-env-secret algorithm=PBEWITHMD5ANDDES
```

The output is Your Key. Paste on your application.properties file.

```sh
spring.datasource.password=ENC(PASTE_OUTPUT_HERE)
```
