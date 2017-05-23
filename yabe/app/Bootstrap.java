import models.User;
import play.jobs.Job;
import play.jobs.OnApplicationStart;
import play.test.Fixtures;

/**
 * Created by cuongbui on 5/23/17.
 */

@OnApplicationStart
public class Bootstrap extends Job {

    @Override
    public void doJob() throws Exception {
        // Check if database is empty
        if (User.count() == 0) {
            Fixtures.loadModels("initial-data.yml");
        }
    }
}
