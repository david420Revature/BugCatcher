package com.revature.browser;

public interface DefectOverviewComponent extends Component {
    default String getDefectOverviewTrailer() {
        return "/defectoverview";
    }
}
