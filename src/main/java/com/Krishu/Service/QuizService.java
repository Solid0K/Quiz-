package com.Krishu.Service;

import com.Krishu.DAO.QuestionDAO;
import com.Krishu.DAO.QuizDAO;
import com.Krishu.Entity.Question;
import com.Krishu.Entity.Quiz;

import java.util.List;

public class QuizService {
    private static final QuizDAO quiz_dao=new QuizDAO();
    private static final QuestionDAO question_dao=new QuestionDAO();

    public static void createNewQuiz(String title,String topic){
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setTopic(topic);
        quiz_dao.saveQuiz(quiz);
        System.out.println("Quiz has been created");
    }

    public static void AddQuestionInQuiz(int quiz_id,String QuizText,String optionA,String optionB,String optionC,
                                         String optionD,String correctOption){
        Question question=new Question();
        Quiz quiz=quiz_dao.getQuizById(quiz_id);
        if(quiz==null){
            System.out.println("Given Quiz is not in database");
            return;
        }
        question.setQuesText(QuizText);
        question.setOptionA(optionA);
        question.setOptionB(optionB);
        question.setOptionC(optionC);
        question.setOptionD(optionD);
        question.setCorrectOption(correctOption);
        question.setQuiz(quiz);
        question_dao.saveQuestion(question);
        quiz.getQuestionList().add(question);
        System.out.println("Question has been added to quiz");
    }

    public static void ShowQuiz(int id){
        Quiz quiz=quiz_dao.getQuizById(id);
        List<Question> listOfQuestions=question_dao.getQuestionsByQuiz(id);
        System.out.println("Quiz: "+quiz.getTitle());
        int count=1;
        for(Question question:listOfQuestions){
            System.out.println(count+". "+question.getQuestionText());
            System.out.println("a. "+question.getOption_A());
            System.out.println("b. "+question.getOption_B());
            System.out.println("c. "+question.getOption_C());
            System.out.println("d. "+question.getOption_D());
            count++;
            System.out.println();
        }
    }
}
