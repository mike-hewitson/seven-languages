# seven-languages

Repo for the team to do the 'Seven Languages in Seven Weeks' book

# Ruby

The sample code all works fine as is.

# Scala

All code samples work correctly now.

kids.scala & sizer.scala had deprecated code and is marked as such now.

The new kids.scala & sizer.scala uses akka actors instead of the deprecated scala methods.

On sizer.scala and sizer_deprecated.scala some of the URL's (usually amazon.com) might return HTTP 503 errors. I think this is a self defence mechanism on the website's side to prevent DDOS attacks.


# Prolog notes
- All warnings have been removed.
- All files compile nicely.
- Remember to always end a statement with a '.'
- The SWIPL version 7.2.3 compiler will return true/false instead of    yes/no.
- To avoid getting undefined method exception, you first need to run    dynamic command before calling methods in the file.
E.G. ?- dynamic fd_all_different/1.
    