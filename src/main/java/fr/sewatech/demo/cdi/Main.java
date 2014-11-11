package fr.sewatech.demo.cdi;

import fr.sewatech.demo.cdi.beans.AnnotatedBean;
import fr.sewatech.demo.cdi.beans.ProgrammaticalBean;
import fr.sewatech.demo.cdi.beans.SimpleBean;
import org.jboss.weld.environment.se.StartMain;
import org.jboss.weld.environment.se.events.ContainerInitialized;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

/**
 * @author Alexis Hassler
 */
@ApplicationScoped
public class Main {


    @Inject
    Instance<ProgrammaticalBean> bean1;

    @Inject
    Instance<AnnotatedBean> bean2;

    @Inject
    Instance<SimpleBean> bean3;

    public static void main(String[] args) {
        StartMain.main(args);
    }

    public void start(@Observes ContainerInitialized event) {
        System.out.println("ProgrammaticalBean " + printResult(bean1));
        System.out.println("AnnotatedBean " + printResult(bean2));
        System.out.println("SimpleBean " + printResult(bean3));
    }

    private String printResult(Instance<?> bean) {
        return (bean.isUnsatisfied() ? " not found" : " found");
    }

}
