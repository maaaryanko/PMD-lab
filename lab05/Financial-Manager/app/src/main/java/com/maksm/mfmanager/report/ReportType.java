package org.gnucash.android.ui.report;

import android.content.Context;
import android.support.annotation.ColorRes;

import org.gnucash.android.R;
import org.gnucash.android.app.GnuCashApplication;
import org.gnucash.android.ui.report.barchart.StackedBarChartFragment;
import org.gnucash.android.ui.report.linechart.CashFlowLineChartFragment;
import org.gnucash.android.ui.report.piechart.PieChartFragment;
import org.gnucash.android.ui.report.sheet.BalanceSheetFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum ReportType {
    PIE_CHART(0), BAR_CHART(1), LINE_CHART(2), TEXT(3), NONE(4);

    Map<String, Class> mReportTypeMap = new HashMap<>();
    int mValue = 4;

    ReportType(int index){
        mValue = index;
        Context context = GnuCashApplication.getAppContext();
        switch (index){
            case 0:
                mReportTypeMap.put(context.getString(R.string.title_pie_chart), PieChartFragment.class);
                break;
            case 1:
                mReportTypeMap.put(context.getString(R.string.title_bar_chart), StackedBarChartFragment.class);
                break;
            case 2:
                mReportTypeMap.put(context.getString(R.string.title_cash_flow_report), CashFlowLineChartFragment.class);
                break;
            case 3:
                mReportTypeMap.put(context.getString(R.string.title_balance_sheet_report), BalanceSheetFragment.class);
                break;
            case 4:
                break;
        }
    }


    public @ColorRes int getTitleColor(){
        switch (mValue){
            case 0:
                return R.color.account_green;
            case 1:
                return R.color.account_red;
            case 2:
                return R.color.account_blue;
            case 3:
                return R.color.account_purple;
            case 4:
            default:
                return R.color.theme_primary;
        }
    }

    public List<String> getReportNames(){
        return new ArrayList<>(mReportTypeMap.keySet());
    }

    public BaseReportFragment getFragment(String name){
        BaseReportFragment fragment = null;
        try {
            fragment = (BaseReportFragment) mReportTypeMap.get(name).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return fragment;
    }
}
