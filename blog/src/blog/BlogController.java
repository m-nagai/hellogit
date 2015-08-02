package blog;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Blog�𑀍삷��r�W�l�X���W�b�N
 * 
 * @author Shinji Miyamoto
 */
public class BlogController {

    /**
     * �V���O���g���̃C���X�^���X
     */
    private static BlogController controller = new BlogController();

    /**
     * �A�ԗp�̃J�E���^
     */
    private int idCounter;

    /**
     * Blog�̃��X�g
     */
    private List<Topic> topics = new ArrayList<Topic>();

    /**
     * ���̃N���X�̃C���X�^���X���擾���܂��B
     * 
     * @return BlogController�̃C���X�^���X
     */
    public static BlogController getInstance() {
        return controller;
    }

    private BlogController() {
    }

    /**
     * �g�s�b�N���|�X�g(�o�^)���܂��B
     * @param topic �g�s�b�N
     */
    public void postTopic(Topic topic) {
        synchronized (this) {
            topic.setId(idCounter++);
            topic.setPostDate(new Date());//���ݎ���
            topics.add(topic);
        }
    }

    /**
     * �ŋ߂�(�Ƃ������S����)�g�s�b�N���擾���܂��B
     * 
     * @return �g�s�b�N�̃��X�g
     */
    public List<Topic> getTopics() {
        return new ArrayList<Topic>(topics);
    }

}