/*
 * Copyright 2002-2006 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package fr.xebia.demo.ws.employee;

import java.sql.Date;
import java.util.GregorianCalendar;

import javax.xml.ws.Holder;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.log4j.Logger;

import fr.xebia.demo.xml.employee.Employee;
import fr.xebia.demo.xml.employee.Gender;

/**
 * @author <a href="mailto:cleclerc@xebia.fr">Cyrille Le Clerc</a>
 */
public class EmployeeServiceImpl implements EmployeeService {
    
    private final static Logger logger = Logger.getLogger(EmployeeServiceImpl.class);
    
    @Override
    public void putEmployee(Holder<Employee> employee) throws EmployeeServiceFaultMsg {
        if (employee.value.getId() == null) {
            throw new NullPointerException("employee.id can NOT be null");
        }
        
        logger.info("putEmployee(" + employee + "): " + ToStringBuilder.reflectionToString(employee));
        
    }
    
    @Override
    public Employee getEmployee(int id) throws EmployeeServiceFaultMsg {
        Employee employee = new Employee();
        employee.setId(id);
        employee.setLastName("Doe");
        employee.setFirstName("John");
        employee.setGender(Gender.MALE);
        employee.setBirthdate(new Date(new GregorianCalendar(1976, 01, 05).getTimeInMillis()));
        
        logger.info("getEmployee(" + id + "): " + ToStringBuilder.reflectionToString(employee));
        return employee;
    }
}
