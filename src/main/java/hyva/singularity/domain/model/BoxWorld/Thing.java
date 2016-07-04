package hyva.singularity.domain.model.BoxWorld;

import hyva.singularity.domain.vo.ThingId;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author by hyvaa on 2016. 6. 18..
 */
@Data
@AllArgsConstructor
public class Thing {

    private final ThingId thingId;

    private MovableType movableType;

}
