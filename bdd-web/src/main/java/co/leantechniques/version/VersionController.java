package co.leantechniques.version;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping(value="/version")
public class VersionController {

  @Autowired
  @Qualifier("version")
  String version;

  @RequestMapping(method=GET)
  @ResponseBody
  public String get(){
    return version;
  }
}
