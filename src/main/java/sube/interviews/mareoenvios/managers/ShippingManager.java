package sube.interviews.mareoenvios.managers;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Map;

@Component
@Transactional
public class ShippingManager {

    @PersistenceContext
    private EntityManager entityManager;

    public void updateShippingState(String sql, Map<String, Object> parameters) {
        entityManager.createNativeQuery(sql)
                .setParameter("id", parameters.get("id"))
                .setParameter("state", parameters.get("state"))
                .executeUpdate();
    }
}
