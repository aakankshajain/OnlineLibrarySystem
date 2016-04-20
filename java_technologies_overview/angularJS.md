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
  <br>
  AngularJS object cab be defined like<br>
  
  div ng-app="" ng-init="person={a='a1',b='b1'}"<br>
  {{person.a}}<br>
  {{person.b}}<br>

AngularJS array can be defined as<br>

div ng-app="" ng-init="person=[1,2,3,4,5]"<br>
{{person[1]}}<br>
{{person[2]}}<br>

AngularJS expression are like java script expresion only the difference is : AJS exp can be written inside HTML nut not JS exp.
and JS exp can contain loops and conditional operator but not AJS.

###AngularJS module

AngularJS modules defined the application.It is a container for the application.<br>
We can create a angularJS module by using method : angular.module("<Module_name>",[])
after creating module we can controller, filters to it.
For eg:

script <br>
var app =angular.module("myapp",[]);
app.controller("myctr",function($scope){
.....

[] indicate that we are creating new module.<br>
If we do not use this it mean we are using existing module.<br>

YTo use this function angu;ar.module(...) we need to first add angularJS library.So it is always preferable to add it in head part or befor boby part in html file.<br>

### AngularJS directives:

These are used to add some more attributes to HTML. all predefined directives have "ng" prefix.<br>
Eg : ng-app : initialize angularJS application.<br>
	ng-init : initialize application variable(generally not used instead controller are used.)<br>
	ng-repeat : can be used where loops are required. eg : in printing array values.<br>
	ng-model : used to bind html values to application data.<br>
				It also provides the facility to check type validation,adds CSS files and bind bind HTML data to HTML forms.<br>
				

We can also define custome directives by using directive method.It can be called like<br>

script<br>

	var app=angular.module("myModule",[]);
	app.directive(myCustomDirective,function(){
	});
/script<br>

Note: Name of the directive should be in camel case when defining it.But when using it it is used with "-" between each word.like : <br>
myCustomeDirective : when created<br>

my-custom-directive : when used in html<br>

these directives can be used as :  HTML element(A), HTML attribute (E), class(C),  comments(M)<br>
We can restrict its use also,By default its scope is EA (mean it can be used with element and attribute)<br>

to restrict its use we use "restrict" keyword when defining the directive.<br>

script<br>
	var app=angular.module("myModule",[])<br>
	app.directive(myCustomDirective,function(){<br>
		return{<br>
			restrict : "A",<br>
			template : "Custome directive"<br>
		};
		
	});

	
### Angular model

Angular model binds html input field data to angularJS variable.This is in bi-direction.If we change value of input field variable's values will also change and vice versa.<br>
It is also used in validations.<br>
Eg :<br>
 span ng-show="formName.fieldName.$error.email"<br>
	write message here<br>
	/span<br>
	
	if formName.fieldName.$error.email will return true message will be shown otherwise not.<br>
	
	we can also check the status.<br>
	
	formName.fieldName.$valid<br>
	formName.fieldName.$touched<br>
	formName.fieldName.$status<br>
	
	There are some css classes which will be added depending on the status.<br>
	
###AngularJS Controller

AngularJS controllers control the application. "ng-controller" directive is used to define controllers.
	

});<br>
/script<br>

### AngularJS scope
scope is binding between view and controller.
scope is an object which is owner of all the application variable and methods present in angularJS application.

An object $rootScope is also available which is availble for whole application.

###AngularJS filters
Filters are used to format data. To use filter in expression add pipe '|' after expression then add filter.
For eg : 
{{name|lowercase}}

AngularJS provides following filters :
currency ,Date ,lowercase, uppercase, orderBy, number, limitTo, json, filter

Facility to develop custome filters is also provided. for this filter function is available in module.
For eg : 
 angular.module("myModule",[]).filter("myFilter",function(){
 
 .....
 return ...
 })
 
 
 ### AngularJS Service
 Services are object or functions present in angularJS application.
 For eg : $location, $timeout, $http, $interval
 
 using $location service we can find out the current url of web page.
 $http can make request to server and get response.
 
 For creating custom services  service method is given in module.
 
 


