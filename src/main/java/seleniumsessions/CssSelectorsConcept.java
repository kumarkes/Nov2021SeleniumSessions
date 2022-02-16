package seleniumsessions;

import org.openqa.selenium.By;

public class CssSelectorsConcept {

	public static void main(String[] args) {

		// svg element does not support cssSelector
		// Backward traversing not allowed in cssSelector so we cannot handle table
		// concept
		// Text functions is not available in cssSelector
		// Syntax wise XPath is little complex than cssSelector

		// {id}->#id, tag#id (For id)
		// class-->.class (For class)
		// input#input-email (Tag and id)
		// .form-control
		// input.form-control (Tag and class)
		// input#input-email.form-control (Tag and id + class)
		// input.form-control#input-email
		// .form-control#input-email (Only class + id)
		By.cssSelector("#input-email");
		// tag[type='submit']
		// input[type='submit']
		By.cssSelector("input[type='submit']");
		// input[type='submit'][value='Login']

		// form-control private-form_control login-email
		// form-control private-form_control login-password m-bottom-3
		// .c1.c2.c3....cn
		// .form-control.private-form_control.login-email
		// input.form-control.private-form_control.login-email
		// input.form-control.private-form__control.login-email#username

		By.cssSelector("input.form-control.private-form__control.login-email");
		By.className("form-control private-form__control login-email");// wrong
		By.xpath("//input[@class='form-control private-form__control login-email']");
		By.className("login-email");

		// input[id*='email'] //contains
		// input[id^='input'] //starts-with
		// input[id$='email'] //ends-with

		// parent to child:
		// div.form-group > input#input-email

		// div#content > div (only direct child elements) -- 1
		// div#content div (direct + indirect) -- 7

		// child to parent: Backward Traversing
		// NA

		// sibling in css:
		// div.form-group label + input

		// ul.footer-nav li:nth-of-type(2)

	}

}
