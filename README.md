# Music_Advisor
JetBrains Academy student project 2 

Using the Spotify authorization guide and the information given here (you need the section Authorization Code Flow), improve your program by adding real authorization on Spotify.

Choose any free port on your machine (for example, 8080), and add the http://localhost:your_port to the whitelist of redirect_uri in your application settings on the Spotify site (Dashboard -> your app -> edit settings -> redirect URIs).
Note that you should use the http protocol for localhost, not https, like in the Spotify example.)
On the auth command, before printing the auth link (from the previous stage), you should start an HTTP server that will listen for the incoming requests. When the user confirms or rejects the authorization, the server should return the following text to the browser:
"Got the code. Return back to your program." if the query contains the authorization code.
"Authorization code not found. Try again." otherwise.
This code is bound to each user who has a Spotify account and uses your app. Actually, you should ask this code once for each new user and save it somewhere.
After the code is received, the server must shut down and you should get access_token by making a POST request on https://accounts.spotify.com/api/token with parameters described in the guide, and then print the response body.
Also, in this stage, you should read the Spotify access server point from the command line argument. Server path should be passed to the program using -access argument. If this argument is not set, you should use a default argument, https://accounts.spotify.com. Make sure you replace constants to this argument value everywhere!

Example
Below is an output example of the described program. Try to output all cases like in the example.

The greater-than symbol followed by a space (> ) represents the user input. Note that it's not part of the input.

> new
Please, provide access for application.
> auth
use this link to request the access code:
https://accounts.spotify.com/authorize?client_id=a19ee7dbfda443b2a8150c9101bfd645&redirect_uri=http://localhost:8080&response_type=code
waiting for code...
code received
making http request for access_token...
response:
{"access_token":"BQBSZ0CA3KR0cf0LxmiNK_E87ZqnkJKDD89VOWAZ9f0QXJcsCiHtl5Om-EVhkIfwt1AZs5WeXgfEF69e4JxL3YX6IIW9zl9WegTmgLkb4xLXWwhryty488CLoL2SM9VIY6HaHgxYxdmRFGWSzrgH3dEqcvPoLpd26D8Y","token_type":"Bearer","expires_in":3600,"refresh_token":"AQCSmdQsvsvpneadsdq1brfKlbEWleTE3nprDwPbZgNSge5dVe_svYBG-RG-_PxIGxVvA7gSnehFJjDRAczLDbbdWPjW1yUq2gtKbbNrCQVAH5ZBtY8wAYskmOIW7zn3IEiBzg","scope":""}
---SUCCESS---
> new
---NEW RELEASES---
Mountains [Sia, Diplo, Labrinth]
Runaway [Lil Peep]
The Greatest Show [Panic! At The Disco]
All Out Life [Slipknot]
> exit
---GOODBYE!---
