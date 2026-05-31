package com.Krishu.Service;

import com.Krishu.DAO.QuestionDAO;
import com.Krishu.DAO.QuizDAO;
import com.Krishu.DAO.ResultDAO;
import com.Krishu.DAO.UserDAO;
import com.Krishu.Entity.Question;
import com.Krishu.Entity.Quiz;
import com.Krishu.Entity.Result;
import com.Krishu.Entity.User;

import java.util.List;
import java.util.Scanner;

public class AttemptService {
    private final static QuizDAO quiz_dao=new QuizDAO();
    private final static QuestionDAO question_dao=new QuestionDAO();
    private final static ResultDAO result_dao=new ResultDAO();
    private final static UserDAO user_dao=new UserDAO();

    public static void AttemptQuiz(int Quiz_id,int user_id){
        Quiz quiz=quiz_dao.getQuizById(Quiz_id);
        List<Question> questions=question_dao.getQuestionsByQuiz(Quiz_id);
        User user=user_dao.getUserById(user_id);
        System.out.println(quiz.getTitle());
        System.out.println(quiz.getTopic());
        int score=CalculateScore(questions);
        System.out.println("Yours score: "+score+"/"+questions.size());
        Result result=new Result();
        result.setScore(score);
        result.setTotalQuestions(questions.size());
        result.setQuiz(quiz);
        result.setUser(user);
        result_dao.SaveResult(result);
    }

    public static int CalculateScore(List<Question> questions){
        Scanner scanner=new Scanner(System.in);
        int score=0;
        int count=1;
        for(Question question:questions){
            System.out.println(count+". "+question.getQuestionText());
            System.out.println("a. "+question.getOption_A());
            System.out.println("b. "+question.getOption_B());
            System.out.println("c. "+question.getOption_C());
            System.out.println("d. "+question.getOption_D());
            System.out.print("Enter your Answer: ");
            String answer=scanner.nextLine();
            if(answer.equals(question.getCorrectOption())){
                score++;
            }
        }
        return score;
    }
}
