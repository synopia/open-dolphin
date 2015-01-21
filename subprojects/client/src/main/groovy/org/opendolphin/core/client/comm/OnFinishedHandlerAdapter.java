package org.opendolphin.core.client.comm;

import org.opendolphin.core.client.GClientPresentationModel;

import java.util.List;
import java.util.Map;

public class OnFinishedHandlerAdapter implements OnFinishedHandler {
    @Override
    public void onFinished(List<GClientPresentationModel> presentationModels) {
        // do nothing
    }

    @Override
    public void onFinishedData(List<Map> data) {
        // do nothing
    }
}
