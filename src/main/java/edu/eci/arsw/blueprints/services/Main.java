package edu.eci.arsw.blueprints.services;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.persistence.BlueprintsPersistence;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        try {
            ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
            BlueprintsServices bs = ac.getBean(BlueprintsServices.class);
            System.out.println(bs.getBlueprint("_authorname_", "_bpname_"));
            System.out.println(bs.getBlueprintsByAuthor("_authorname_"));
            Blueprint bp = new Blueprint("yo", "plano");
            bs.addNewBlueprint(bp);
            System.out.println(bs.getBlueprintsByAuthor("yo"));
            //bs.addNewBlueprint(bp);
            System.out.println(bs.getAllBlueprints());
        } catch (BlueprintNotFoundException | BlueprintPersistenceException e) {
            e.printStackTrace();
        }
    }

}
