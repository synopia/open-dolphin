package org.opendolphin.demo.crud

class PortfolioConstants {

    static class TYPE {
        public static final String PORTFOLIO = PortfolioConstants.unique 'type'
    }

    static class ATT {
        public static final String NAME      = 'name'
        public static final String FIXED     = 'fixed'
        public static final String TOTAL     = 'total'
        public static final String DOMAIN_ID = 'domainId'
    }

    static class CMD {
        public static final String PULL      = PortfolioConstants.unique 'pull'
        public static final String UPDATE    = PortfolioConstants.unique 'update'
    }

    static class PM_ID {
        public static final String SELECTED  = PortfolioConstants.unique 'selected'
    }

    static String unique(String s) { PortfolioConstants.class.name + '.'+ s }

    static String pmId(String type, int index) { type + "-" + index}

}
