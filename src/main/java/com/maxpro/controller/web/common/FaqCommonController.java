package com.maxpro.controller.web.common;

import com.maxpro.model.Faq;
import com.maxpro.model.custom.CustomError;
import com.maxpro.support.repository.FaqRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import java.util.List;


@Controller
public class FaqCommonController {

    private final String BASE_PATH = "/common/faq";
    private final String FAQ_INDEX_PAGE = BASE_PATH + "/index";

    @Autowired
    private FaqRepository faqRepository;

    @RequestMapping(path = "/faqs", method = RequestMethod.GET)
    public String faq(Model model) {
        List<Faq> faqs = faqRepository.findAll();
        model.addAttribute("faqs", faqs);
        return FAQ_INDEX_PAGE;
    }

    @RequestMapping(path = "/faq/add", method = RequestMethod.POST)
    @ResponseBody
    public CustomError addFaq(WebRequest webRequest) {
        String question = webRequest.getParameter("question");
        Faq faq = new Faq(question, null);
        faqRepository.save(faq);

        return new CustomError(200, "Saved Successfully");
    }

}
