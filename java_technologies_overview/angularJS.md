# AngularJS

AngularJS is a framework which can be used to extend the features of HTML. It is a kind of library which is written in java script.

AngularJS can be added in an HTML file using "script" tag.

script<br>
  src="//angular js source"<br>
/script<br>

html tags with ng prefix are angular JS directives.for eg:<br>

ng-app : defines a block belongs to angularJS.<br>
ng-model : binds the value of html element to application variable.<br>
ng-bind : binds value of application variable to html element.<br>
ng-init :  declare and initialize angularJS application variable.<br>

AngularJS expression is written in double braces.({{}}).It can contain variables,operators and contants. AngularJS expressions are like java script expression.Everytime whenever we write it in angularJS application it will calculate the expression and will show the result, but wont in non angularJS expression.<br>

  input type="text" ng-model="angJS" /input <br>
  p **{{angJS}}** /p
  
AngularJS modules defined the application.Eg : ng-app<br>
AngularJS controllers control the application.Eg : ng-controller


