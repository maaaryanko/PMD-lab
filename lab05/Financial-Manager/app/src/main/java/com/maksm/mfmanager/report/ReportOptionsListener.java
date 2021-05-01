package org.gnucash.android.ui.report;

import org.gnucash.android.model.AccountType;

/**
 * Listener interface for passing reporting options from activity to the report fragments
 */
public interface ReportOptionsListener {

    /**
     * Notify the implementing class of the selected date range
     * @param start Start date in milliseconds since epoch
     * @param end End date in milliseconds since epoch
     */
    void onTimeRangeUpdated(long start, long end);

    /**
     * Updates the listener on a change of the grouping for the report
     * @param groupInterval Group interval
     */
    void onGroupingUpdated(ReportsActivity.GroupInterval groupInterval);

    /**
     * Update to the account type for the report
     * @param accountType Account type
     */
    void onAccountTypeUpdated(AccountType accountType);
}
