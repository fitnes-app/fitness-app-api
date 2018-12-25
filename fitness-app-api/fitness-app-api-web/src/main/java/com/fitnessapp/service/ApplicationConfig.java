/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fitnessapp.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Naluem
 */
@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> resources = new java.util.HashSet<>();
		addRestResourceClasses(resources);
		return resources;
	}

	/**
	 * Do not modify addRestResourceClasses() method.
	 * It is automatically populated with
	 * all resources defined in the project.
	 * If required, comment out calling this method in getClasses().
	 */
	private void addRestResourceClasses(Set<Class<?>> resources) {
		resources.add(com.fitnessapp.service.AdministratorFacadeREST.class);
		resources.add(com.fitnessapp.service.AdvancedClientTrackingFacadeREST.class);
		resources.add(com.fitnessapp.service.AdvancedExerciseFacadeREST.class);
		resources.add(com.fitnessapp.service.AdvancedWorkoutFacadeREST.class);
		resources.add(com.fitnessapp.service.AnswerFacadeREST.class);
		resources.add(com.fitnessapp.service.AssignedFacadeREST.class);
		resources.add(com.fitnessapp.service.BasicClientTrackingFacadeREST.class);
		resources.add(com.fitnessapp.service.BasicExerciseFacadeREST.class);
		resources.add(com.fitnessapp.service.BasicWorkoutFacadeREST.class);
		resources.add(com.fitnessapp.service.BodyTypeFacadeREST.class);
		resources.add(com.fitnessapp.service.ClientFacadeREST.class);
		resources.add(com.fitnessapp.service.CustomRoutineFacadeREST.class);
		resources.add(com.fitnessapp.service.DailyAdvancedWorkoutFacadeREST.class);
		resources.add(com.fitnessapp.service.DailyTipFacadeREST.class);
		resources.add(com.fitnessapp.service.MeasurementFacadeREST.class);
		resources.add(com.fitnessapp.service.MuscularGroupFacadeREST.class);
		resources.add(com.fitnessapp.service.QuestionFacadeREST.class);
		resources.add(com.fitnessapp.service.SpecialityFacadeREST.class);
		resources.add(com.fitnessapp.service.SpecificTipFacadeREST.class);
		resources.add(com.fitnessapp.service.SurveyFacadeREST.class);
        resources.add(com.fitnessapp.service.TagFacadeREST.class);
        resources.add(com.fitnessapp.service.TrainerFacadeREST.class);
	}
	
}
