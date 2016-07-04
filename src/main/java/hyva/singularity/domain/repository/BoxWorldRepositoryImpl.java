package hyva.singularity.domain.repository;

import hyva.singularity.domain.model.BoxWorld.BoxWorld;
import hyva.singularity.domain.vo.OwnerKey;
import hyva.singularity.utility.ThisIsMock;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author by hyvaa on 2016. 6. 18..
 */
@ThisIsMock
@Component
public class BoxWorldRepositoryImpl implements BoxWorldRepository {

    private static Map<OwnerKey, BoxWorld> worldMap = new HashMap<>();

    @Override
    public void save(BoxWorld... boxWorlds) {
        for(BoxWorld boxWorld : boxWorlds) {
            worldMap.put(boxWorld.getOwnerKey(), boxWorld);
        }
    }

    @Override
    public BoxWorld findOne(OwnerKey ownerKey) {
        return worldMap.get(ownerKey);
    }

    @Override
    public List<BoxWorld> findAll() {
        return (List<BoxWorld>) worldMap.values();
    }

    @Override
    public void delete(OwnerKey... ownerKey) {
        if(null == ownerKey) {
            return;
        }
        worldMap.remove(ownerKey);
    }
}
