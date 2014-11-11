package fr.sewatech.demo.cdi.extensions;

import fr.sewatech.demo.cdi.Main;
import fr.sewatech.demo.cdi.beans.ProgrammaticalBean;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.BeforeBeanDiscovery;
import javax.enterprise.inject.spi.Extension;

/**
 * @author Alexis Hassler
 */
public class ConfigurationExtension implements Extension {
    public void addHashMapAsAnnotatedType(@Observes BeforeBeanDiscovery bbd, BeanManager beanManager) {
        bbd.addAnnotatedType(
                beanManager.createAnnotatedType(Main.class));
        bbd.addAnnotatedType(
                beanManager.createAnnotatedType(ProgrammaticalBean.class));
    }

}
