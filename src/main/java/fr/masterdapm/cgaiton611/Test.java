package fr.masterdapm.cgaiton611;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class Test
{
    public static void main( String[] args )
    {
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("testjpa");

        EntityManager em = null;
        int i= 0, maxTentatives = 10;
        while  (i < maxTentatives) {
            try {
                em = emf.createEntityManager();
                i = maxTentatives + 999;
            }
            catch (Exception e){
                System.out.println("Erreur à la connexion à la BDD, nouvelle tentative ...");
                i += 1;
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        }

        if (i == maxTentatives){
            System.out.println("Erreur connexion BDD, exit");
            System.exit(1);
        }


        Personne p1 = new Personne(1, "Pierre","Durand");

        EntityTransaction transac = em.getTransaction();

        transac.begin();
        Personne p2 = em.find(Personne.class, p1.getId());
        if (p2 != null) System.out.println(p1.getNom());
        else{
            System.out.println("null");
            em.persist(p1);
        }
        transac.commit();
    }
}
