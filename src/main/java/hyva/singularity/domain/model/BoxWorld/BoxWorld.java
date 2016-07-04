package hyva.singularity.domain.model.BoxWorld;

import hyva.singularity.domain.vo.OwnerKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Singular;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author by hyvaa on 2016. 6. 18..
 */
@Data
@AllArgsConstructor
public class BoxWorld {

    @NotNull
    private final OwnerKey ownerKey;

    @Singular
    private List<Thing> things;

}
