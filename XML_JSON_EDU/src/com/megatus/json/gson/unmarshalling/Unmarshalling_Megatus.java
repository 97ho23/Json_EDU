package com.megatus.json.gson.unmarshalling;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.megatus.vo.EmployeeVO;
import com.megatus.vo.MegatusVO;

public class Unmarshalling_Megatus {

	public static void main(String[] args) {

		String jsonFile = "./json/marshall_Megatus.json";
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		FileOutputStream fos = null;
		JsonReader jsonReader = null;
		MegatusVO newMegatus = new MegatusVO();

		// 검색조회
		try {

			jsonReader = new JsonReader(new FileReader(jsonFile));
			MegatusVO megatus = gson.fromJson(jsonReader, MegatusVO.class);
			List<EmployeeVO> employeeList = new ArrayList<EmployeeVO>();

			for (EmployeeVO employee : megatus.getEmployee()) {
				// if (employee.getName() = "JuHo") { 이러면 안돼
				if (employee.getName().equals("JuHo")) {
					System.out.println("-------검색조회-------");
					System.out.println("Name : " + employee.getName());
					System.out.println("Age : " + employee.getAge());
					System.out.println("isNew : " + employee.isNew());
					System.out.println();

					employee.setAge(29);
					System.out.println("---------수정---------");
					System.out.println("Name : " + employee.getName());
					System.out.println("Age : " + employee.getAge());
					System.out.println("isNew : " + employee.isNew());
					System.out.println();
				}
				employeeList.add(employee);
			}

			// 새로운 사원 추가
			EmployeeVO newEmployee = new EmployeeVO();
			newEmployee.setName("HoMin");
			newEmployee.setAge(40);
			newEmployee.setNew(false);
			employeeList.add(newEmployee);
			megatus.setEmployee(employeeList);

			// 수정된 파일 저장
			fos = new FileOutputStream("./json/marshall_New_Megatus.json");
			String jsonInString01 = gson.toJson(megatus);
			fos.write(jsonInString01.getBytes());

			System.out.println("Json File Save Success");

		} catch (Exception e) {
			e.getMessage();
		} finally {
			if (jsonReader != null)
				try {
					jsonReader.close();
				} catch (Exception e) {
					e.getMessage();
				}
			if (fos != null)
				try {
					fos.close();
				} catch (Exception e) {
					e.getMessage();
				}
		}
	}

}
