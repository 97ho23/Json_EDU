package com.megatus.json.gson.marshalling;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.megatus.vo.EmployeeVO;
import com.megatus.vo.MegatusVO;

public class Marshalling_Megatus {

	public static void main(String[] args) {

		String jsonFile = "./json/marshall_Megatus.json";

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		FileOutputStream fos = null;

		MegatusVO megatus = createMegatus();

		try {

			fos = new FileOutputStream(jsonFile);
			String jsonInString01 = gson.toJson(megatus);
			fos.write(jsonInString01.getBytes());
			
			System.out.println("Json File Save Success");

		} catch (Exception e) {
			e.getMessage();
		} finally {
			if (fos != null)
				try {
					fos.close();
				} catch (Exception e) {
					e.getMessage();
				}
		}

	}

	private static MegatusVO createMegatus() {

		MegatusVO megatus = new MegatusVO();
		List<EmployeeVO> employeeList = new ArrayList<EmployeeVO>();
		
		megatus.setCompany("Megatus");
		megatus.setAddress("Guro-gu");
		megatus.setNumber("025630117");

		EmployeeVO employee01 = new EmployeeVO();
		employee01.setName("HyunSik");
		employee01.setAge(29);
		employee01.setNew(false);
		employeeList.add(employee01);
		megatus.setEmployee(employeeList);

		EmployeeVO employee02 = new EmployeeVO();
		employee02.setName("JuHo");
		employee02.setAge(25);
		employee02.setNew(true);
		employeeList.add(employee02);
		megatus.setEmployee(employeeList);

		EmployeeVO employee03 = new EmployeeVO();
		employee03.setName("JiYoung");
		employee03.setAge(24);
		employee03.setNew(true);
		employeeList.add(employee03);
		megatus.setEmployee(employeeList);

		EmployeeVO employee04 = new EmployeeVO();
		employee04.setName("HyeSung");
		employee04.setAge(24);
		employee04.setNew(true);
		employeeList.add(employee04);
		megatus.setEmployee(employeeList);

		return megatus;
	}

}
