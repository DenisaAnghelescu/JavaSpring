package com.javabuc17.exampleProject.CircularDependencySolutions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

//            -----------------CIRCULAR DEPENDENCY-----------------
@Profile("dev")
@Component("serviciu")
public class Test1 {

}
