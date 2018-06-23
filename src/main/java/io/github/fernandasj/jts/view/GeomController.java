package io.github.fernandasj.jts.view;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;
import io.github.fernandasj.jts.model.SvgInfo;
import io.github.fernandasj.jts.model.SvgFactory;
import io.github.fernandasj.jts.model.ViewBox;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author fernanda
 */
@Controller
public class GeomController {

    @GetMapping("/")
    public String doGet() {
        return "index";
    }

    @PostMapping("/result")
    public String doPost(Model model, @RequestParam String geometryA, @RequestParam String geometryB) {
        List<SvgInfo> geometries = new ArrayList<>();
        Map<String, Object> attributes = new HashMap<>();

        try {

            WKTReader reader = new WKTReader();

            Geometry a = reader.read(geometryA);
            Geometry b = reader.read(geometryB);

            attributes.put("equalsAB", a.equals(b));
            attributes.put("equalsBA", b.equals(a));

            attributes.put("disjointAB", a.disjoint(b));
            attributes.put("disjointBA", b.disjoint(a));

            attributes.put("intersectsAB", a.intersects(b));
            attributes.put("intersectsBA", b.intersects(a));

            attributes.put("touchesAB", a.touches(b));
            attributes.put("touchesBA", b.touches(a));

            attributes.put("crossesAB", a.crosses(b));
            attributes.put("crossesBA", b.crosses(a));

            attributes.put("withinAB", a.within(b));
            attributes.put("withinBA", b.within(a));

            attributes.put("containsAB", a.contains(b));
            attributes.put("containsBA", b.contains(a));

            attributes.put("overlapsAB", a.overlaps(b));
            attributes.put("overlapsBA", b.overlaps(a));

            attributes.put("coversAB", a.covers(b));
            attributes.put("coversBA", b.covers(a));

            attributes.put("coveredByAB", a.coveredBy(b));
            attributes.put("coveredByBA", b.coveredBy(a));

            ViewBox viewBox = new ViewBox(a, b);
            attributes.put("viewBox", viewBox.getViewBox());

            geometries.add(new SvgInfo(SvgFactory.getSvg(a), "#4834d4"));
            geometries.add(new SvgInfo(SvgFactory.getSvg(b), "#95afc0"));
            attributes.put("geometries", geometries);

            model.addAllAttributes(attributes);

        } catch (ParseException ex) {
            Logger.getLogger(GeomController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "result";
    }
}
