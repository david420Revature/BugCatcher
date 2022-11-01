package com.revature.browser;

public interface DefectReporterComponent extends Component {
    default String getDefectReporterTrailer() {
        return "/defectreporter";
    }
}
