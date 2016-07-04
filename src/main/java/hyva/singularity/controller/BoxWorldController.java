package hyva.singularity.controller;

import hyva.singularity.domain.model.BoxWorld.BoxWorld;
import hyva.singularity.domain.service.BoxWorldService;
import hyva.singularity.domain.vo.OwnerKey;
import hyva.singularity.utility.ForTest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author by hyvaa on 2016. 6. 18..
 */

@Slf4j
@RestController
@RequestMapping("world")
public class BoxWorldController {

    @Resource
    private BoxWorldService boxWorldService;

    @RequestMapping(value = "owner/{ownerKey}", method = RequestMethod.POST)
    public void create(@PathVariable String ownerKey, BoxWorld boxWorld) {
        log.debug("owner: {}, create boxWorld{}", ownerKey, boxWorld);
        boxWorldService.create(new OwnerKey(ownerKey), boxWorld);
    }

    @RequestMapping(value = "owner/{ownerKey}", method = RequestMethod.GET)
    public BoxWorld read(@PathVariable String ownerKey) {
        BoxWorld boxWorld = boxWorldService.get(new OwnerKey(ownerKey));
        log.debug("owner: {}, read boxWorld{}", ownerKey, boxWorld);
        return boxWorld;
    }

    @ForTest
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<BoxWorld> readAll() {
        return boxWorldService.getAllWorld();
    }

    @ForTest
    @RequestMapping(value = "owner/{ownerKey}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String ownerKey) {
        BoxWorld boxWorld = boxWorldService.get(new OwnerKey(ownerKey));
        log.debug("owner: {}, delete target boxWorld{}", ownerKey, boxWorld);
        boxWorldService.delete(new OwnerKey(ownerKey));
    }

}
