

## Java EE web application

+ IDE: Eclipse Jee Oxygen

+ Server: Tomcat v7
+ localhost:8080/MP1_Keypad_app

> The primary function of the program is to convert the string to a 
> sequence of digits

Simulating your phone keypad, the alphabets are mapped to digits as follows: 

`ABC(2), DEF(3), GHI(4), JKL(5), MNO(6),`
`PQRS(7), TUV(8), WXYZ(9)`

Please note that 1 will remain as 1 and 0 as 0.


The user's input phone number and its equivalent numerical phone number are produced as outputs of the app. It will also include our local 
telecommunications mobile phone numbers as its prefix

- **SMART**: `0919, 0920, 0960, and 0992`

- **GLOBE**: `0917, 0927, 0926 and 0935` 

- **SUN** : `0922, 0933, 0951 and 0972`


### Note

Input validations are performed to check if the input number for 
the phone exceeds or is lower than 7 characters, the input for Telco 
should be integer and should not be higher or lower than 4 numbers. The 
telecommunications company would be stored on a cookie and converted 
number will be on the session object

**Sample input**: 0919-mVpD1rk

### Issues

> Produces nullPointerException on the first run because of 
> ck[0].getValue() for some reason and also the cookie value does not 
> update immediately. It only gets the last cookie value

**Quick fix**: Remove the `ck[0].getValue()` from DisplayInfoServlet.java on 
the first run then try running the app again