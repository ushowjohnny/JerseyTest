package com.edittw;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/order")
public class Order {

	// private static Logger logger = LoggerFactory.getLogger(Order.class);

	private Object env;

	public Object getEnv() {
		return env;
	}

	public void setEnv(Object env) {
		this.env = env;
	}

	@GET
	@Path("louis")
	public Object value() {
		env = executeCommand("printenv");
		System.out.println(env);
		return Response.status(Status.OK).entity(env).build();
	}

	public String executeCommand(String command) {

		StringBuffer output = new StringBuffer();

		Process p;
		try {
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

			String line = "";
			while ((line = reader.readLine()) != null) {
				output.append(line + "\n");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return output.toString();

	}

	@GET
	@Path("newt")
	public String get() {
		return "Hello, Newt";
	}

	public int evaluateSuccess(String expression) {
		int sum = 0;
		for (String summand : expression.split("\\+"))
			sum += Integer.valueOf(summand);
		return sum;
	}

	public int evaluateFail(String expression) {
		int sum = 0;
		for (String su : expression.split("\\+"))
			sum -= Integer.valueOf(su);
//			System.out.println(su);
//			sum += Integer.valueOf(su);
		return sum;
	}
}