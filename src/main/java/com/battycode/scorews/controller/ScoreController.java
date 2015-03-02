package com.battycode.scorews.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.battycode.scorews.dto.Score;

@Controller
@RequestMapping("/user-score")
public class ScoreController {

	private final AtomicLong id = new AtomicLong();
	private final AtomicLong score = new AtomicLong();

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody Score userBestScore(@RequestParam(value = "userId", required = false, defaultValue = "0") long userId) {
		return new Score(this.id.incrementAndGet(), userId, this.score.incrementAndGet());
	}

}