package com.bigc;

import com.bigc.mapper.EmpMapper;
import com.bigc.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@SpringBootTest
class SpringbootMybatisCrudApplicationTests {

	@Autowired
	private EmpMapper empMapper;

	@Test
	public void testDelete() {
		int delete = empMapper.delete(20);
		System.out.println(delete);
	}

	@Test
	public void testInsert() {
		// 构造员工对象
		Emp emp = new Emp();
		emp.setUsername("Tom2");
		emp.setName("汤姆2");
		emp.setImage("1.jpg");
		emp.setGender((short)1);
		emp.setJob((short)1);
		emp.setEntrydate(LocalDate.of(2000, 1, 1));
		emp.setCreateTime(LocalDateTime.now());
		emp.setUpdateTime(LocalDateTime.now());
		emp.setDeptId(1);

		// 执行新增员工信息操作
		empMapper.insert(emp);
		System.out.println(emp.getId());
	}

	@Test
	public void testUpdate() {
		// 构造员工对象
		Emp emp = new Emp();
		emp.setId(19);
		emp.setUsername("Tom111222");
		emp.setName("汤姆111");
		// emp.setImage("1.jpg");
		emp.setGender((short)2);
		// emp.setJob((short)1);
		// emp.setEntrydate(LocalDate.of(2000, 1, 1));
		emp.setUpdateTime(LocalDateTime.now());
		// emp.setDeptId(1);

		// 执行更新员工操作
		empMapper.update(emp);
	}

	// 根据ID查询员工
	@Test
	public void testGetByID() {
		Emp emp = empMapper.getByID(21);
		System.out.println(emp);
	}

	// 根据条件查询员工
	@Test
	public void testList() {
		List<Emp> emmpList = empMapper.list("张", (short) 1, null, null);
		System.out.println(emmpList);
	}

	@Test
	public void testDeleteByIds() {
		List<Integer> ids = Arrays.asList(11, 12, 13);
		empMapper.deleteByIds(ids);
	}


}
