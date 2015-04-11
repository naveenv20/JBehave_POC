package com.sample.JBehavePOC.Utilities;

import java.util.List;
import org.jbehave.core.Embeddable;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

import com.sample.JBehavePOC.Steps.Common_actions;
import com.sample.JBehavePOC.Steps.Customercarecheck;
import com.sample.JBehavePOC.Steps.Searchresults;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;
import static org.jbehave.core.reporters.Format.CONSOLE;  
import static org.jbehave.core.reporters.Format.HTML;
import static org.jbehave.core.reporters.Format.TXT;
import static org.jbehave.core.reporters.Format.XML;



public class TestRunnerStories extends JUnitStories  {
   
	 public TestRunnerStories() {
		 super();  
	    }
	
	
	@Override  
	   public Configuration configuration() {  
		 Class<? extends Embeddable> embeddableClass = this.getClass();
	
		 
		return new MostUsefulConfiguration().useStoryReporterBuilder(new StoryReporterBuilder()
        .withCodeLocation(CodeLocations.codeLocationFromClass(embeddableClass))
        .withDefaultFormats()
        .withFormats(CONSOLE, TXT, HTML, XML));
	        
	}  
	
	// Here we specify the steps classes  
	   @Override  
	   public InjectableStepsFactory stepsFactory() {  
	     
			try {
				return new InstanceStepsFactory(configuration(),new Customercarecheck(),new Searchresults(),new Common_actions());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		
	   }  
 
	 
	  /* @Override
	    protected List<String> storyPaths() {
	        List<String> storiesToRun = new ArrayList<String>();
	        String storyProperty = System.getProperty("story");

	        if (storyProperty == null || storyProperty.isEmpty()) {
	           throw new RuntimeException("Please specify which stories to run");
	        }

	        String[] storyNames = storyProperty.split(",");
	        StoryFinder sf = new StoryFinder();
	        URL baseUrl = CodeLocations.codeLocationFromClass(this.getClass());
	        System.out.println("&^&^&^&^&"+baseUrl);

	        for (String storyName : storyNames) {
	           storiesToRun.addAll(sf.findPaths(baseUrl, storyName, ""));
	        }

	        return storiesToRun;
	    }
	    */
	   
	   //Command to run selective tests
	   //mvn clean test -Dwebdriver.firefox.bin="C:\Program Files\Mozilla\Firefox\firefox.exe" -Dstory=myStory.story  

	   
	  @Override
	   protected List<String> storyPaths() {
	      return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()), "**/*.story", "**/excluded*.story");
	   }

	   
   
}
