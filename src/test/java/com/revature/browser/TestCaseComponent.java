package com.revature.browser;

public interface TestCaseComponent extends Component {
    default String getTestCaseTrailer() {
        return "/testcases";
    }
}
