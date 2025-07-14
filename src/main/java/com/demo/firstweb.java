package com.demo;

import java.util.Comparator;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class firstweb {


@GetMapping (value="/get")
public String get() {
	return ("Hello World");
}
@GetMapping(value="/name")
public String name() {
	return ("Senthil");
}
@GetMapping(value="/getvalue/{a}")
public String gets(@PathVariable String a) {
	return "Hello"+" "+a;
}
@GetMapping(value="getmax/{a}/{b}")
public int gets(@PathVariable int a,@PathVariable int b) {
	if(a>b) {
		return a;
	}
	else {
		return b;
	}
}
@GetMapping(value="/getvalues")
public String value(@RequestParam String a,@RequestParam String b) {
	if(a.equals("Hello")&& b.equals("World")) {
		return "Path is Correct";
	}
	else {
		return "Pathb is incorect";
	}
}
@GetMapping(value="/getcorrect")
public String values(@RequestParam String username,@RequestParam String passcode) {
	if(username.equals("Senthil")&& passcode.equals("Sen@10")) {
		return "Valid";
	}
	else {
			return "Not Valid";
		}
	}
@GetMapping(value="/getstd/{name}")
public String values(@PathVariable String name,@RequestParam int ID) {
	return "Name - "+name+", "+"ID - "+ID;
	
}
@GetMapping(value="/getmail/{password}")
public String values1(@RequestParam String emailId,@PathVariable String password ) {
	if(emailId.equals("senthil@10gmail.com")&&password.equals("sen@10")) {
		return "Open";
	}
	else {
		return "End";
	}
}
@PostMapping(value="/getemp")
public String gets(@RequestBody Employee e) {
	  return e.getName()+" "+e.getId()+" "+e.getSalary() ;
}
@PostMapping(value="/getemps")
public Employee gets(@RequestBody List<Employee> e) {
	 // return e.stream().map(x->x.getSalary()).max(Comparable::compareTo).get();
	return e.stream().max(Comparator.comparing(Employee :: getSalary)).get();
}
@PostMapping(value="/getmaxemps")
public Employee get(@RequestBody List<Employee> e) {
	return e.stream().sorted(Comparator.comparing(Employee :: getSalary).reversed()).skip(1).findFirst().get();
}
@PostMapping(value="/getmaxemp")
public boolean getvalue(@RequestBody List<Employee> e) {
	return e.stream().map(x->x.getName()).anyMatch(x->x.equals("Ram"));
			}
@PostMapping(value="/getsal/{salary}")
public boolean getvalues(@RequestBody List<Employee> e,@PathVariable int salary) {
	return e.stream().anyMatch(x->x.getSalary() == salary);
	
}
@PostMapping(value="/twoways/{n}/{i}")
public String twoways(@PathVariable String n, @PathVariable int i,
		@RequestBody List<Employee> e4) {
	for(Employee emp : e4) {
		if (emp.getName().equalsIgnoreCase(n) && emp.getId()==i) {
			return "id & name is correct";
		}
	}
	return "incorrect";
}
@GetMapping(value="/prime/{a}")
public String getsval(@PathVariable int a){
	boolean isPrime=true;
	for(int i=2;i<a;i++){
		if(a%i == 0) {
			isPrime=false;	
		}
		
	}
	if(isPrime == true) {
		return "Is a Prime Number";
	}
	else {
		return "Not a Prime Number";
	}
	}


@GetMapping(value="/nmae")
public String getname() {
	return ("Hello this Senthil's New World");
}
}
		










