package com.leeo.web.controller;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ModelQuery;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"modeler"})
public class ModelerController
{
  private static Logger logger = LoggerFactory.getLogger(ModelerController.class);
  private ProcessEngine processEngine;
  private JsonMapper jsonMapper = new JsonMapper();

  @RequestMapping({"modeler-list"})
  public String list(org.springframework.ui.Model model)
  {
    List models = this.processEngine.getRepositoryService()
      .createModelQuery().list();
    model.addAttribute("models", models);

    return "modeler/modeler-list";
  }

  @RequestMapping({"modeler-open"})
  public String open(@RequestParam(value="id", required=false) String id) throws Exception
  {
    RepositoryService repositoryService = this.processEngine
      .getRepositoryService();
    org.activiti.engine.repository.Model model = repositoryService.getModel(id);

    if (model == null) {
      model = repositoryService.newModel();
      repositoryService.saveModel(model);
      id = model.getId();
    }

    return "redirect:/modeler.html?modelId=" + id;
  }

  @RequestMapping({"modeler-remove"})
  public String remove(@RequestParam("id") String id) {
    this.processEngine.getRepositoryService().deleteModel(id);

    return "redirect:/modeler/modeler-list.do";
  }

  @RequestMapping({"model/{modelId}/json"})
  @ResponseBody
  public String openModel(@PathVariable("modelId") String modelId)
    throws Exception
  {
    RepositoryService repositoryService = this.processEngine
      .getRepositoryService();
    org.activiti.engine.repository.Model model = repositoryService.getModel(modelId);

    if (model == null) {
      logger.info("model({}) is null", modelId);
      model = repositoryService.newModel();
      repositoryService.saveModel(model);
    }

    Map root = new HashMap();
    root.put("modelId", model.getId());
    root.put("name", "name");
    root.put("revision", Integer.valueOf(1));
    root.put("description", "description");

    byte[] bytes = repositoryService.getModelEditorSource(model.getId());

    if (bytes != null) {
      String modelEditorSource = new String(bytes, "utf-8");
      logger.info("modelEditorSource : {}", modelEditorSource);

      Map modelNode = (Map)this.jsonMapper.fromJson(modelEditorSource, Map.class);
      root.put("model", modelNode);
    } else {
      Map modelNode = new HashMap();
      modelNode.put("id", "canvas");
      modelNode.put("resourceId", "canvas");

      Map stencilSetNode = new HashMap();
      stencilSetNode.put("namespace", 
        "http://b3mn.org/stencilset/bpmn2.0#");
      modelNode.put("stencilset", stencilSetNode);

      model.setMetaInfo(this.jsonMapper.toJson(root));
      model.setName("name");
      model.setKey("key");

      root.put("model", modelNode);
    }

    logger.info("model : {}", root);

    return this.jsonMapper.toJson(root);
  }

  @RequestMapping({"editor/stencilset"})
  @ResponseBody
  public String stencilset() throws Exception {
    InputStream stencilsetStream = super.getClass().getClassLoader()
      .getResourceAsStream("stencilset.json");
    try
    {
      return IOUtils.toString(stencilsetStream, "utf-8");
    } catch (Exception e) {
      throw new RuntimeException("Error while loading stencil set", e);
    }
  }

  @RequestMapping({"model/{modelId}/save"})
  @ResponseBody
  public String modelSave(@PathVariable("modelId") String modelId, @RequestParam("description") String description, @RequestParam("json_xml") String jsonXml, @RequestParam("name") String name, @RequestParam("svg_xml") String svgXml)
    throws Exception
  {
    RepositoryService repositoryService = this.processEngine
      .getRepositoryService();
    org.activiti.engine.repository.Model model = repositoryService.getModel(modelId);
    model.setName(name);

    logger.info("jsonXml : {}", jsonXml);
    repositoryService.saveModel(model);
    repositoryService.addModelEditorSource(model.getId(), 
      jsonXml.getBytes("utf-8"));

    return "{}";
  }

  @Resource
  public void setProcessEngine(ProcessEngine processEngine)
  {
    this.processEngine = processEngine;
  }
}