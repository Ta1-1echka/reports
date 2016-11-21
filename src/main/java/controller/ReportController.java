package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.ReportServiceImpl;

/**
 * ReportController
 */

@Controller
@RequestMapping("/")
public class ReportController {

    @Autowired
    private ReportServiceImpl reportService;

    /**
     * Adding performers object to model before visiting report.jsp
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getReportPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("report");
        modelAndView.addObject("performers", reportService.getAllPerformers());
        return modelAndView;
    }

    /**
     * Adding resultReportsList object to model after check incoming params
     * If all income params is empty return all reports in database, else return all reports in accordance with incoming params
     *
     * @param modelAndView
     * @param startDate
     * @param endDate
     * @param performer
     * @return
     */

    @RequestMapping(value = "getReportList", method = RequestMethod.POST)
    public ModelAndView getReportList(ModelAndView modelAndView,
                                      @RequestParam(value = "hiddenStartDate", required = false) String startDate,
                                      @RequestParam(value = "hiddenEndDate", required = false) String endDate,
                                      @RequestParam(value = "hiddenPerformer", required = false) String performer) {

        if (startDate.equals("") & endDate.equals("") & performer.equals("")) {
            modelAndView.addObject("resultReportsList", reportService.getAllEntity());
        } else {
            modelAndView.addObject("resultReportsList", reportService.getAllEntityByPeriodAndPerformer(startDate, endDate, performer));
        }
        modelAndView.setViewName("report");
        modelAndView.addObject("performers", reportService.getAllPerformers());
        return modelAndView;
    }
}
